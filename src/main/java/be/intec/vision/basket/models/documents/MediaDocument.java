package be.intec.vision.basket.models.documents;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Objects;

@Data
@NoArgsConstructor ( force = true, access = AccessLevel.PUBLIC )
@FieldDefaults ( level = AccessLevel.PRIVATE )
@Document ( value = "medias" )
public class MediaDocument {

	public enum Type {
		PNG, JPG, BMP, GIF, // IMAGES
		MP4, AVI, MKV,  // VIDEOS
		STL, OBJ // 3D OBJECTS
	}


	@MongoId
	String id;

	Type type;

	String title;

	String altText;

	String width;

	String height;

	String url;

	Boolean isExternal;

	Boolean active = Boolean.TRUE;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof MediaDocument)) return false;
		MediaDocument that = (MediaDocument) o;
		return Objects.equals(getId(), that.getId()) && getUrl().equals(that.getUrl());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getUrl());
	}

	@Override
	public String toString() {
		return this.getTitle() + this.getUrl() ;
	}
}
