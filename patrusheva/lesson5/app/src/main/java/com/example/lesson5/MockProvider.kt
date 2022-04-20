package com.example.lesson5

object MockProvider {

    fun getMockPosts() = listOf(
        Post(
            0,
            "Some very long text that probably won't fit on a single line. Some very long text that probably won't fit on a single line. Some very long text that probably won't fit on a single line. Some very long text that probably w...",
            "https://unsplash.com/photos/IuJc2qh2TcA/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjQ4NTYxNTE3&force=true&w=640",
        ),
        Post(
            1,
            "Some text here...",
            "",
        ),
        Post(
            2,
            "",
            "https://unsplash.com/photos/BHJs5TZ-Nt0/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8NXx8Y2F0fGVufDB8Mnx8fDE2NDg1NDE2NDI&force=true&w=640",
        ),
        Post(
            3,
            "Some very long text that probably won't fit on a single line. Some very long text that probably won't fit on a single line. Some very long text that probably won't fit on a single line. Some very long text that probably won't fit on a single line. Some very long text that probably won't fit on a single line.",
            "",
        ),
    )
}