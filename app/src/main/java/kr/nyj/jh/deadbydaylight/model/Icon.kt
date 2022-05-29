package kr.nyj.jh.deadbydaylight.model

import com.google.gson.annotations.SerializedName

class Icon(
    @SerializedName("portrait")
    val portrait: String,

    @SerializedName("preview_portrait")
    val preview_portrait: String,

    @SerializedName("shop_background")
    val shop_background: String,
)