package net.inherency.example

data class Person (
        val name: String,
        var age: Int,
        val emailList: List<String> = emptyList(),
        val nickname: String? = null
): Comparable<Person> {

    override fun compareTo(other: Person): Int {
        return  compareByAge(other) ?:
                compareByName(other) ?:
                compareByEmailCount(other) ?:
                0
    }

    private fun compareByAge(other: Person): Int? {
        return compareAndReturnNullWhenEqual(this.age, other.age)
    }

    private fun compareByName(other: Person): Int? {
        return compareAndReturnNullWhenEqual(this.name, other.name)
    }

    private fun compareByEmailCount(other: Person): Int? {
        return compareAndReturnNullWhenEqual(this.emailList.size, other.emailList.size)
    }

    private fun <T: Comparable<T>> compareAndReturnNullWhenEqual(thisObj: Comparable<T>, thatObj: T): Int? {

        //val result = thisObj.compareTo(thatObj)
        //return if (result == 0) null else result

        if (thisObj < thatObj) return -1
        if (thisObj > thatObj) return 1
        return null
    }

}
