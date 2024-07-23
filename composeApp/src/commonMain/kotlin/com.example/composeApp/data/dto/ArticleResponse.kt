package com.example.composeApp.data.dto

import com.example.composeApp.data.models.Article
import kotlinx.serialization.Serializable

@Serializable
data class ArticleResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)


/*
{
    "status": "ok",
    "totalResults": 6141,
    -"articles": [
    -{
    -"source": {
        "id": "wired",
        "name": "Wired"
    },
    "author": "Joel Khalili",
    "title": "Craig Wright Faces Perjury Investigation Over Claims He Created Bitcoin",
    "description": "By order of a UK judge, Craig Wright can no longer claim he is the creator of bitcoin and now faces the prospect of criminal charges.",
    "url": "https://www.wired.com/story/craig-wright-perjury-bitcoin-trial/",
    "urlToImage": "https://media.wired.com/photos/6696630a5d2d61e4805c3175/191:100/w_1280,c_limit/GettyImages-1979197796.jpg",
    "publishedAt": "2024-07-16T12:58:12Z",
    "content": "A judge in the UK High Court has directed prosecutors to consider bringing criminal charges against computer scientist Craig Wright, after ruling that he lied extensively and repeatedly and committed… [+2851 chars]"
}*/
