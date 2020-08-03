package com.mark.findit

class Document {
    private var item_name: String? = null
    private var category: String? = null
    private var uid: String? = null
    private var location: String? = null
    private var documentId: String? = null
    fun User(item_name: String?, category: String, location: String?, uid: String?, documentId: String?) {
        this.item_name = item_name
        this.category = category
        this.uid = uid
        this.location = location
        this.documentId = documentId
    }

    fun getName(): String? {
        return item_name
    }

    fun setName(name: String?) {
        this.item_name = name
    }

    fun getCategory(): String? {
        return category
    }

    fun setCategory(category: String) {
        this.category = category
    }

    fun location(): String? {
        return location
    }

    fun setLocation(location: String?) {
        this.location = location
    }

    fun getUid(): String? {
        return uid
    }

    fun setUid(id: String?) {
        this.uid = id
    }

    override fun toString(): String {
        return item_name.toString()
    }
}