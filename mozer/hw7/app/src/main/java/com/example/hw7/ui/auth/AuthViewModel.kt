package com.example.hw7.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw7.data.model.CheckUsernameResponse
import com.example.hw7.data.model.CheckUsernameResultApi
import com.example.hw7.domain.usecase.AddTokenUseCase
import com.example.hw7.domain.usecase.CheckUsernameUseCase
import com.example.hw7.domain.usecase.AuthorizationUseCase
import com.example.hw7.domain.usecase.RegistrationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okio.IOException
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val checkUsernameUseCase: CheckUsernameUseCase,
    private val authorizationUseCase: AuthorizationUseCase,
    private val registrationUseCase: RegistrationUseCase,
    private val addTokenUseCase: AddTokenUseCase
) : ViewModel() {

    private val _checkUsernameApiLiveData = MutableLiveData<CheckUsernameResponse>()
    val checkUsernameApiLiveData: LiveData<CheckUsernameResponse> = _checkUsernameApiLiveData

    private val _checkUsernameLiveData = MutableLiveData<CheckUsernameResult>()
    val checkUsernameLiveData: LiveData<CheckUsernameResult> = _checkUsernameLiveData

    private val _checkPasswordLiveData = MutableLiveData<CheckPasswordResult>()
    val checkPasswordLiveData: LiveData<CheckPasswordResult> = _checkPasswordLiveData

    private val _navigateLiveData = MutableLiveData<Any>()
    val navigateLiveData: LiveData<Any> = _navigateLiveData

    private val _exceptionLiveData = MutableLiveData<Any>()
    val exceptionLiveData: LiveData<Any> = _exceptionLiveData

    private var _username: String = ""

    private var _password: String = ""

    private val regex = "[a-z],[_],[.]".toRegex()

    fun onUsernameChanged(username: String) {
        _username = username
    }

    fun onPasswordChanged(password: String) {
        _password = password
    }

    fun onContinueClicked() {
        when (_checkUsernameApiLiveData.value?.result) {
            CheckUsernameResultApi.Free -> registration(_username, _password)
            CheckUsernameResultApi.Taken -> authorization(_username, _password)
            else -> checkUsername()
        }
    }


    private fun validatePassword(): Boolean {
        return when {
            _password.length < 3 -> {
                _checkPasswordLiveData.value = CheckPasswordResult.TooShort
                false
            }
            _password.length > 16 -> {
                _checkPasswordLiveData.value = CheckPasswordResult.TooLong
                false
            }
            else -> {
                true
            }
        }
    }

    private fun checkUsername() {
        viewModelScope.launch {
            if (validateUsername()) {
                val response = checkUsernameUseCase(_username)
                _checkUsernameApiLiveData.value = response
            }
        }
    }

    private fun validateUsername(): Boolean {
        return when {
            _username.length < 3 -> {
                _checkUsernameLiveData.value = CheckUsernameResult.TooShort
                false
            }

            _username.length > 16 -> {
                _checkUsernameLiveData.value = CheckUsernameResult.TooLong
                false
            }
            regex.matches(_username) -> {
                _checkUsernameLiveData.value = CheckUsernameResult.InvalidCharacters
                false
            }
            else -> {
                true
            }
        }
    }

    private fun authorization(username: String, password: String) {
        viewModelScope.launch {
            if (validatePassword()) {
                try {
                    val token = authorizationUseCase(username, password)
                    addTokenUseCase(token.token)
                    _navigateLiveData.value = Any()
                }
                catch (e: IOException){
                    _exceptionLiveData.value = Any()
                }
            }
        }
    }

    private fun registration(username: String, password: String) {
        viewModelScope.launch {
            if (validatePassword()) {
                val token = registrationUseCase(username, password)
                addTokenUseCase(token.token)
                _navigateLiveData.value = Any()
            }
        }
    }

}
