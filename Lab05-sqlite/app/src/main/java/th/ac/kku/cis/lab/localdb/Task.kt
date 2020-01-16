package th.ac.kku.cis.lab.localdb

class Task {
    var id: Int = 0
    var name: String? = null


    constructor(id: Int, name: String) {
        this.id = id
        this.name = name
    }

    constructor(name: String) {
        this.id = id
        this.name = name
    }
}