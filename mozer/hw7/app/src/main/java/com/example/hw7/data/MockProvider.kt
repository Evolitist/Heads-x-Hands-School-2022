package com.example.hw7.data

import com.example.hw7.model.Post

object MockProvider {

    fun getMockPost(id: Int) = Post(
        id = list.get(id).id,
        text = list.get(id).text,
        imageURL = list.get(id).imageURL
    )

    fun getListPosts() = list

    private val list = listOf(
        Post(
            0,
            "Some very long text that probably won't fit on a single line. Some very long text that probably won't fit on a single line. Some very long text that probably won't fit on a single line. Some very long text that probably won't fit on a single line.",
            "https://unsplash.com/photos/IuJc2qh2TcA/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjQ4NTYxNTE3&force=true&w=640"
        ),

        Post(
            1,
            "Some short text",
            ""
        ),

        Post(
            2,
            "Some short text",
            "https://unsplash.com/photos/BHJs5TZ-Nt0/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8NXx8Y2F0fGVufDB8Mnx8fDE2NDg1NDE2NDI&force=true&w=640"
        ),

        Post(
            3,
            "Some very long text that probably won't fit on a single line. Some very long text that probably won't fit on a single line. Some very long text that probably won't fit on a single line. Some very long text that probably won't fit on a single line.",
            ""
        )
    )
}