package ru.bsuedu.savestate

import android.os.Parcel
import android.os.Parcelable

class StateParcelable(
    val value: String = "",
    val size: Float = 0F,
    val color: Int = 0,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readFloat(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(value)
        parcel.writeFloat(size)
        parcel.writeInt(color)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<StateParcelable> {
        override fun createFromParcel(parcel: Parcel): StateParcelable {
            return StateParcelable(parcel)
        }

        override fun newArray(size: Int): Array<StateParcelable?> {
            return arrayOfNulls(size)
        }
    }
}