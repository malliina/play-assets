package controllers

//import com.malliina.assets.AppAssets
import com.malliina.play.tags.TagPage

import scalatags.Text.all._
import com.malliina.play.tags.All._

object AppTags {
  def index(msg: String) = TagPage(
    html(
      head(
//        cssLink(AppAssets.css.styles)
      ),
      body(
        h1(`class` := "demo")(msg)
      )
    )
  )
}
