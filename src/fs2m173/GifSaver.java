package fs2m173;
/**
 * 实现ImageSaver接口，把图片保存为gif
 * @author cifengwang
 *
 */
public class GifSaver implements ImageSaver{
	@Override
	public void save() {
		System.out.println("image is saved as gif");
	}

}
