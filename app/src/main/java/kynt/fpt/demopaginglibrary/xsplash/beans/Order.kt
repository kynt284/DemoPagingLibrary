package kynt.fpt.demopaginglibrary.xsplash.beans

enum class Order constructor(val order: String) {

    LATEST("latest"),
    OLDEST("oldest"),
    POPULAR("popular")
}
