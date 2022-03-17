package be.intec.vision.basket.models.requests;


import be.intec.vision.basket.models.responses.MediaResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MediaRequest {


    public enum Type {
        PNG, JPG, BMP, GIF, JPEG, JFIF, EXIF, TIFF, WEBP, HDR, HEIF, BAT, // IMAGES
        MP4, AVI, MKV, MOV, WMV, AVCHD, FLV, F4V, SWF, WEBM, MPEG,MPG, MP2, MPE, MPV, OGG, QT,   // VIDEOS
        STL, OBJ, MF, DS, MAX, COLLADA, VRML, X3D, STEP, FBX   // 3D OBJECTS
    }


    @MongoId
    String id;
    Type type=Type.PNG;

    String title;

    String altText;

    String width;

    String height;

    String url;


    public void setUrl(String url) {
        String fileName = "student-records.pdf";
        String fe = "";
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            fe = fileName.substring(i + 1);
            this.type = Type.valueOf(fe.toUpperCase());
        }
        this.url = url;
    }



}
