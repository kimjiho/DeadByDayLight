package kr.nyj.jh.deadbydaylight.model

import com.google.gson.annotations.SerializedName
import java.util.*

class Survivors (
    @SerializedName("_id")
    val id: String,

    @SerializedName("role")
    val role: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("gender")
    val gender: String,

    @SerializedName("nationality")
    val nationality: String,

    @SerializedName("voice_actor")
    val voice_actor: String,

    @SerializedName("difficulty")
    val difficulty: String,

    @SerializedName("dlc")
    val dlc: String,

    @SerializedName("dlc_id")
    val dlc_id: Number,

    @SerializedName("is_ptb")
    val is_ptb: Boolean,

    @SerializedName("is_free")
    val is_free: Boolean,

    @SerializedName("lang")
    val lang: String,

    @SerializedName("icon")
    val icon: Objects,

    @SerializedName("overview")
    val overview: String,

    @SerializedName("perks")
    val perks: Array<String>,
)

class Icon(
    @SerializedName("portrait")
    val portrait: String,

    @SerializedName("preview_portrait")
    val preview_portrait: String,

    @SerializedName("shop_background")
    val shop_background: String,
)
//"_id": "5f46a992a3777022ec625f24",
//"name": "Dwight Fairfield",
//"full_name": null,
//"name_tag": "DF",
//"gender": "Male",
//"role": "Nervous Leader",
//"nationality": "American",
//"voice_actor": "Ian Chuprun",
//"overview": "Dwight Fairfield is a nervous Leader, able to locate his allies and increase their effectiveness.\r\n\r\nHis personal Perks, Bond, Prove Thyself, and Leader, allow him to get in proximity of other Survivors and provide bonuses to their actions as well as his own.\r\n\r\nHe is skilled at finding others and working as a group. His Perks help him and others by keeping them together and alive.",
//"lore": "Dwight was geeky and scrawny through high school. He always wanted to be one of the cool kids, but somehow never had the charisma. He tried out for the football team but was cut, the basketball team didn't even take a look, and his grades were distinctly below average. One weekend, on a team-building exercise from his dead-end job, Dwight's boss led them deep into the woods before breaking out his family recipe moonshine. Dwight remembered taking the first sip before waking up late the next morning all alone. During the night, the others had abandoned him. Once again, the laughing stock of the community Dwight tried to hike his way out of the woods. That was the last anyone ever heard of Dwight Fairfield.\r\n\r\nDwight isn't the typical guy you think of when someone says \"Survivor\". He lacks that certain pizzazz and without his glasses, he's more or less blind. But as the sun sets and the woods come alive, Dwight clasps to his rat race life, making sure that he'll live to see another day even though something unimaginable is after him. Dwight won't stop. He'll survive no matter what. As others spent hours being seen in high school. He spent hours becoming invisible and avoiding danger. And it doesn't matter if it's dangers in the hallway or dangers in the woods. Survival is key. As other employees panic when terror infects them, Dwight makes use of his disturbing teen experience. The tables have now turned and now others need to follow to Dwight's firm directions if they are to survive as he knows how to disappear.",
//"difficulty": "Easy",
//"dlc": "Base Game",
//"dlc_id": 381210,
//"is_free": true,
//"is_ptb": false,
//"lang": "en",
//"icon": {
//    "portrait": "https://raw.githubusercontent.com/dearvoodoo/dbd/master/Killers/Portrait/DF.png",
//    "preview_portrait": "https://raw.githubusercontent.com/dearvoodoo/dbd/master/Killers/PreviewPortrait/DF.png",
//    "shop_background": "https://raw.githubusercontent.com/dearvoodoo/dbd/master/Killers/ShopBG/DF.png"
//},
//"perks": [
//"Bond",
//"ProveThyself",
//"Leader"
//]


