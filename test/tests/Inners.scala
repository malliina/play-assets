package tests

import com.malliina.assets.AppAssets
import org.scalatest.FunSuite

class Inners extends FunSuite {

  test("inner paths") {
    assert(MyDir.top === "top.css")
    assert(MyDir.hmm.middle === "hmm/middle.js")
    assert(MyDir.hmm.last.dada === "hmm/last/dada.js")
  }

  test("asset paths") {
    assert(AppAssets.css.styles.toString === "/assets/css/styles.css")
    assert(AppAssets.js.code.toString === "/assets/js/code.js")
    assert(AppAssets.css.`class`.toString === "/assets/css/class.css")
  }

  class Dir(val prefix: String)

  object MyDir extends Dir("") {
    def top = prefix + "top.css"

    object hmm extends Dir(prefix + "hmm/") {
      def middle = prefix + "middle.js"

      object last extends Dir(prefix + "last/") {
        def dada = prefix + "dada.js"
      }

    }

  }

}
