package uts.c14210265.app

import android.os.Parcel
import android.os.Parcelable

data class Kontak (
    val nama: String?,
    val telp: String?,
    val email: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nama)
        parcel.writeString(telp)
        parcel.writeString(email)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Kontak> {
        override fun createFromParcel(parcel: Parcel): Kontak {
            return Kontak(parcel)
        }

        override fun newArray(size: Int): Array<Kontak?> {
            return arrayOfNulls(size)
        }
    }
}