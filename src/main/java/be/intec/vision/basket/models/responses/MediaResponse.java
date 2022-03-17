package be.intec.vision.basket.models.responses;


import be.intec.vision.basket.models.documents.MediaDocument;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@NoArgsConstructor ( force = true, access = AccessLevel.PUBLIC )
@AllArgsConstructor
@FieldDefaults ( level = AccessLevel.PRIVATE )
@JsonIgnoreProperties ( ignoreUnknown = true )
public class MediaResponse {

	public enum Type {
		PNG, JPG, BMP, GIF, JPEG, JFIF, EXIF, TIFF, WEBP, HDR, HEIF, BAT, // IMAGES
		MP4, AVI, MKV, MOV, WMV, AVCHD, FLV, F4V, SWF, WEBM, MPEG,MPG, MP2, MPE, MPV, OGG, QT,   // VIDEOS
		STL, OBJ, MF, DS, MAX, COLLADA, VRML, X3D, STEP, FBX   // 3D OBJECTS
	}




	String id;

	Type type;

	String title;

	String altText;

	String width;

	String height;

	String url;

	Boolean isExternal;

	Boolean active;

}
