package com.example.hw5


object MockProvider {
    val text1 =
        "Some very long text that probably won't fit on a single line. Some very long text " +
                "that probably won't fit on a single line. Some very long text that probably won't fit" +
                " on a single line. Some very long text that probably w..."

    val text2 = "Some text here..."

    val image1 =
        "https://unsplash.com/photos/BHJs5TZ-Nt0/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8NXx8Y2F0fGVufDB8Mnx8fDE2NDg1NDE2NDI&force=true&w=640"

    val image2 =
        "https://unsplash.com/photos/IuJc2qh2TcA/download?ixid=MnwxMjA3fDB8MXxhbGx8fHx8fHx8fHwxNjQ4NTYxNTE3&force=true&w=640"

    val posts = listOf<Post>(

        Post(
            System.currentTimeMillis().toInt(),
            text1,
            image1
        ),

        Post(
            System.currentTimeMillis().toInt(),
            text2,
            null
        ),

        Post(
            System.currentTimeMillis().toInt(),
            text2,
            image2
        ),

        Post(
            System.currentTimeMillis().toInt(),
            text1,
            null
        )
    )
}