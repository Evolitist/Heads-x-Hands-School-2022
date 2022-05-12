package com.example.hw7.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.hw7.R
import com.example.hw7.data.model.CheckUsernameResultApi
import com.example.hw7.databinding.FragmentAuthBinding
import com.google.android.material.textfield.TextInputEditText
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthFragment : Fragment() {

    private lateinit var binding: FragmentAuthBinding
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (viewModel.haveToken()) {
            findNavController().navigate(R.id.action_authFragment_to_feedFragment)
        }

        binding.password.isVisible = false

        binding.tiLogin.doAfterTextChanged {
            viewModel.onUsernameChanged(it?.toString() ?: "")
        }
        binding.tiPassword.doAfterTextChanged {
            viewModel.onPasswordChanged(it?.toString() ?: "")
        }

        binding.btnContinue.setOnClickListener {
            viewModel.onContinueClicked()
        }

        binding.tiLogin.actionListener(viewModel)
        binding.tiPassword.actionListener(viewModel)

        viewModel.navigateLiveData.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_authFragment_to_feedFragment)
        }

        viewModel.exceptionLiveData.observe(viewLifecycleOwner) {
            binding.password.error = "Password is incorrect"
        }

        viewModel.validateUsernameLiveData.observe(viewLifecycleOwner) {
            when (it) {
                ValidateUsernameResult.TooShort -> {
                    binding.login.error = "Username must be longer than 3 characters"
                }
                ValidateUsernameResult.TooLong -> {
                    binding.login.error = "Username must be shorter than 16 characters"
                }
                ValidateUsernameResult.InvalidCharacters -> {
                    binding.login.error = "Username contains invalid characters"
                }
                else -> {
                    throw IllegalStateException("Something went wrong")
                }
            }
        }

        viewModel.validatePasswordLiveData.observe(viewLifecycleOwner) {
            when (it) {
                ValidatePasswordResult.TooShort -> {
                    binding.password.error = "Password must be longer than 3 characters"
                }
                ValidatePasswordResult.TooLong -> {
                    binding.password.error = "Username must be shorter than 16 characters"
                }
                else -> {
                    binding.password.error = null
                }
            }
        }

        viewModel.checkUsernameApiLiveData.observe(viewLifecycleOwner) {
            when (it.result) {
                CheckUsernameResultApi.TooShort -> {
                    binding.login.error = "Username must be longer than 3 characters"
                }
                CheckUsernameResultApi.TooLong -> {
                    binding.login.error = "Username must be shorter than 16 characters"
                }
                CheckUsernameResultApi.InvalidCharacters -> {
                    binding.login.error = "Username contains invalid characters"
                }
                CheckUsernameResultApi.Taken -> {
                    binding.login.error = null
                    binding.password.isVisible = true
                    binding.login.isEnabled = false
                }
                CheckUsernameResultApi.Free -> {
                    binding.login.error = null
                    binding.password.isVisible = true
                    binding.login.isEnabled = false
                }
            }
        }
    }
}

fun TextInputEditText.actionListener(viewModel: AuthViewModel) {
    this.setOnEditorActionListener { _, actionId, _ ->
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            viewModel.onContinueClicked()
            true
        } else false
    }
}