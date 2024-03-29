package kynt.fpt.demopaginglibrary.xsplash.beans;


import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Photo implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("downloads")
    @Expose
    private Integer downloads;
    @SerializedName("likes")
    @Expose
    private Integer likes;
    @SerializedName("liked_by_user")
    @Expose
    private Boolean likedByUser;
    @SerializedName("exif")
    @Expose
    private Location location;
    @SerializedName("current_user_collections")
    @Expose
    private List<Collection> currentUserCollections = new ArrayList<>();
    @SerializedName("urls")
    @Expose
    private Urls urls;

    protected Photo(Parcel in) {
        id = in.readString();
        createdAt = in.readString();
        updatedAt = in.readString();
        if (in.readByte() == 0) {
            width = null;
        } else {
            width = in.readInt();
        }
        if (in.readByte() == 0) {
            height = null;
        } else {
            height = in.readInt();
        }
        color = in.readString();
        if (in.readByte() == 0) {
            downloads = null;
        } else {
            downloads = in.readInt();
        }
        if (in.readByte() == 0) {
            likes = null;
        } else {
            likes = in.readInt();
        }
        byte tmpLikedByUser = in.readByte();
        likedByUser = tmpLikedByUser == 0 ? null : tmpLikedByUser == 1;
        location = in.readParcelable(Location.class.getClassLoader());
    }

    public static final Creator<Photo> CREATOR = new Creator<Photo>() {
        @Override
        public Photo createFromParcel(Parcel in) {
            return new Photo(in);
        }

        @Override
        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };

    @SuppressWarnings({"unchecked"})
    public Photo createFromParcel(Parcel in) {
        Photo instance = new Photo();
        instance.id = ((String) in.readValue((String.class.getClassLoader())));
        instance.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        instance.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        instance.width = ((Integer) in.readValue((Integer.class.getClassLoader())));
        instance.height = ((Integer) in.readValue((Integer.class.getClassLoader())));
        instance.color = ((String) in.readValue((String.class.getClassLoader())));
        instance.downloads = ((Integer) in.readValue((Integer.class.getClassLoader())));
        instance.likes = ((Integer) in.readValue((Integer.class.getClassLoader())));
        instance.likedByUser = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        instance.location = ((Location) in.readValue((Location.class.getClassLoader())));
        instance.urls = ((Urls) in.readValue((Urls.class.getClassLoader())));
        in.readList(instance.currentUserCollections, (Collection.class.getClassLoader()));
        return instance;
    }

    public Photo[] newArray(int size) {
        return (new Photo[size]);
    }


    /**
     * No args constructor for use in serialization
     */
    public Photo() {
    }

    /**
     * @param currentUserCollections
     * @param location
     * @param width
     * @param downloads
     * @param id
     * @param updatedAt
     * @param height
     * @param color
     * @param createdAt
     * @param likes
     * @param likedByUser
     */
    public Photo(String id, String createdAt, String updatedAt, Integer width, Integer height, String color, Integer downloads, Integer likes, Boolean likedByUser, Location location, List<Collection> currentUserCollections, Urls urls) {
        super();
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.width = width;
        this.height = height;
        this.color = color;
        this.downloads = downloads;
        this.likes = likes;
        this.likedByUser = likedByUser;
        this.location = location;
        this.urls = urls;
        this.currentUserCollections = currentUserCollections;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Photo withId(String id) {
        this.id = id;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Photo withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Photo withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Photo withWidth(Integer width) {
        this.width = width;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Photo withHeight(Integer height) {
        this.height = height;
        return this;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Photo withColor(String color) {
        this.color = color;
        return this;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    public Photo withDownloads(Integer downloads) {
        this.downloads = downloads;
        return this;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Photo withLikes(Integer likes) {
        this.likes = likes;
        return this;
    }

    public Boolean getLikedByUser() {
        return likedByUser;
    }

    public void setLikedByUser(Boolean likedByUser) {
        this.likedByUser = likedByUser;
    }

    public Photo withLikedByUser(Boolean likedByUser) {
        this.likedByUser = likedByUser;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Photo withLocation(Location location) {
        this.location = location;
        return this;
    }

    public List<Collection> getCurrentUserCollections() {
        return currentUserCollections;
    }

    public void setCurrentUserCollections(List<Collection> currentUserCollections) {
        this.currentUserCollections = currentUserCollections;
    }

    public Photo withCurrentUserCollections(List<Collection> currentUserCollections) {
        this.currentUserCollections = currentUserCollections;
        return this;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    public Photo withUrls(Urls urls) {
        this.urls = urls;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(width);
        dest.writeValue(height);
        dest.writeValue(color);
        dest.writeValue(downloads);
        dest.writeValue(likes);
        dest.writeValue(likedByUser);
        dest.writeValue(location);
        dest.writeValue(urls);
        dest.writeList(currentUserCollections);
    }

    public int describeContents() {
        return 0;
    }

}
