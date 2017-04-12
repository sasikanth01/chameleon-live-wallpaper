package arun.com.chameleonskinforkwlp.engine;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v7.graphics.Palette;

public class Swatch implements Parcelable {
    @ColorInt
    private int backgroundColor;
    @ColorInt
    private int foregroundColor;

    public Swatch(@ColorInt int backgroundColor, @ColorInt int foregroundColor) {
        this.backgroundColor = backgroundColor;
        this.foregroundColor = foregroundColor;
    }

    Swatch(@Nullable Palette.Swatch paletteSwatch) {
        if (paletteSwatch != null) {
            this.backgroundColor = paletteSwatch.getRgb();
            this.foregroundColor = paletteSwatch.getTitleTextColor();
        }
    }

    private Swatch(Parcel in) {
        backgroundColor = in.readInt();
        foregroundColor = in.readInt();
    }

    public static final Creator<Swatch> CREATOR = new Creator<Swatch>() {
        @Override
        public Swatch createFromParcel(Parcel in) {
            return new Swatch(in);
        }

        @Override
        public Swatch[] newArray(int size) {
            return new Swatch[size];
        }
    };

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(@ColorInt int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getForegroundColor() {
        return foregroundColor;
    }

    public void setForegroundColor(@ColorInt int foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Swatch swatch = (Swatch) o;

        return backgroundColor == swatch.backgroundColor && foregroundColor == swatch.foregroundColor;

    }

    @Override
    public int hashCode() {
        int result = backgroundColor;
        result = 31 * result + foregroundColor;
        return result;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(backgroundColor);
        dest.writeInt(foregroundColor);
    }

    @Override
    public String toString() {
        return "Swatch{" +
                "backgroundColor=" + backgroundColor +
                ", foregroundColor=" + foregroundColor +
                '}';
    }

}