package fun.chaoxi.toutiao.bean.media;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Wing Gao
 * @date 2018/12/13 14:26
 * @description
 */
public class MediaChannelBean implements Parcelable {

    public static final Creator<MediaChannelBean> CREATOR = new Creator<MediaChannelBean>() {
        @Override
        public MediaChannelBean createFromParcel(Parcel source) {
            return new MediaChannelBean(source);
        }
        @Override
        public MediaChannelBean[] newArray(int size) {
            return new MediaChannelBean[size];
        }
    };

    private String id;
    private String name;
    private String avatar;
    private String type;
    private String followCount;
    private String descText;
    private String url;

    public MediaChannelBean() {
    }

    protected MediaChannelBean(Parcel in) {
        // 反序列化
        this.id = in.readString();
        this.name = in.readString();
        this.avatar = in.readString();
        this.type = in.readString();
        this.followCount = in.readString();
        this.descText = in.readString();
        this.url = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // 好像序列化
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(avatar);
        dest.writeString(type);
        dest.writeString(followCount);
        dest.writeString(descText);
        dest.writeString(url);
    }

    public static Creator<MediaChannelBean> getCREATOR() {
        return CREATOR;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFollowCount() {
        return followCount;
    }

    public void setFollowCount(String followCount) {
        this.followCount = followCount;
    }

    public String getDescText() {
        return descText;
    }

    public void setDescText(String descText) {
        this.descText = descText;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "MediaChannelBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", type='" + type + '\'' +
                ", followCount='" + followCount + '\'' +
                ", descText='" + descText + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
