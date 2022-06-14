package kr.nyj.jh.deadbydaylight.model

import com.google.gson.annotations.SerializedName

data class Perks(
    @SerializedName("_id")
    val id: String,

    @SerializedName("role")
    val role: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("name_tag")
    val name_tag: String,

    @SerializedName("perk_name")
    val perk_name: String,

    @SerializedName("perk_tag")
    val perk_tag: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("teach_level")
    val teach_level: Int,

    @SerializedName("is_ptb")
    val is_ptb: Boolean,

    @SerializedName("lang")
    val lang: String,

    @SerializedName("icon")
    val icon: String
)
