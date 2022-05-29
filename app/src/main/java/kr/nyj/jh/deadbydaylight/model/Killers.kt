package kr.nyj.jh.deadbydaylight.model

import com.google.gson.annotations.SerializedName
import java.util.*

class Killers(
    @SerializedName("_id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("full_name")
    val full_name: String,

    @SerializedName("gender")
    val gender: String,

    @SerializedName("nationality")
    val nationality: String,

    @SerializedName("power")
    val power: String,

    @SerializedName("weapon")
    val weapon: String,

    @SerializedName("speed")
    val speed: String,

    @SerializedName("difficulty")
    val difficulty: String,

    @SerializedName("overview")
    val overview: String,

    @SerializedName("lore")
    val lore: String,

    @SerializedName("icon")
    val icon: Icon,

    @SerializedName("perks")
    val perks: Array<String>,
)

//"_id": "5f4706f2a3777022ec6261b3",
//"name": "Trapper",
//"name_tag": "TR",
//"full_name": "Evan MacMillan",
//"alias": "Chuckles",
//"gender": "Male",
//"nationality": "American",
//"realm": "The MacMillan Estate",
//"power": "Bear Trap",
//"weapon": "The Cleaver",
//"speed": "115 % | 4.6 m/s",
//"terror_radius": "32",
//"height": "Tall",
//"voice_actor": "Filip Ivanovic",
//"difficulty": "Easy",
//"overview": "The Trapper is an area-control Killer, able to apply pressure across the Map by placing deadly Bear Traps for Survivors to step into.His personal Perks, Unnerving Presence, Brutal Strength, and Agitation, allow him to chase and carry Survivors more effectively.He is focused on physical attributes and making use of his strength and the Survivors' fear.",
//"lore": "Evan MacMillan idolised his father. It wasn't just that he was heir to a great fortune, it was the way he ran the estate. Raised under his firm hand, Evan had taken to running the workforce with an iron hand. Production was always high and the MacMillan Estate prospered under father and son.\n\nAs Archie MacMillan's mental health slowly disintegrated, Evan protected him from the herd who wanted a piece of the fortune. No matter what his father asked of him, Evan would do.\n\nWhen Archie MacMillan finally snapped, Evan became his enforcer in what would become known as the worst mass murder in modern history. They never proved that Evan lead over a hundred men into those dark tunnels before detonating the explosives and sealing them to their fate.The tale of the MacMillan Estate is a tale of wealth and power gone very wrong.\n\nHow many victims fell to the hands of father and son is unknown. No record is ever made of what became of Evan MacMillan. His father is another unsolved puzzle, found trapped in the locked basement of his own warehouse - starved and abandoned.",
//"dlc": "Base Game",
//"dlc_id": 381210,
//"is_free": true,
//"is_ptb": false,
//"lang": "en",
//"icon": {
//    "portrait": "https://raw.githubusercontent.com/dearvoodoo/dbd/master/Killers/Portrait/TR.png",
//    "preview_portrait": "https://raw.githubusercontent.com/dearvoodoo/dbd/master/Killers/PreviewPortrait/TR.png",
//    "shop_background": "https://raw.githubusercontent.com/dearvoodoo/dbd/master/Killers/ShopBG/TR.png"
//},
//"perks": [
//"UnnervingPresence",
//"BrutalStrength",
//"Agitation"
//]