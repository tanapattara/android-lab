package th.ac.kku.cis.lab.firebasedbapplication

class ToDo {
    companion object Factory {
        fun create(): ToDo = ToDo()
    }

    var objectId: String? = null
    var todoText: String? = null
    var done: Boolean? = false
}
