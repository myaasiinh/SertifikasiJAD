package com.ecomerce.model;

import android.os.Parcel
import android.os.Parcelable


@Parcelize
data class Image(
    val imageSrc: Int,
    val imageId: Int,
    val imageDesc: String?,
    val imageDesc1: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(imageSrc)
        parcel.writeInt(imageId)
        parcel.writeString(imageDesc)
        parcel.writeString(imageDesc1)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Image> {
        override fun createFromParcel(parcel: Parcel): Image {
            return Image(parcel)
        }

        override fun newArray(size: Int): Array<Image?> {
            return arrayOfNulls(size)
        }
    }
}

annotation class Parcelize
