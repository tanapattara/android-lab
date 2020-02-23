package th.ac.kku.cis.lab.firebasedbapplication

interface ItemRowListener {
    fun modifyItemState(itemObjectId: String, index: Int, isDone: Boolean)
    fun onItemDelete(itemObjectId: String, index: Int)
}
