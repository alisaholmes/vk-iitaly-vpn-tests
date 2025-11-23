package video_vk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import video_vk.pages.VideoVkPage;

public class VideoTest extends BaseTestVK {

    @Test
    public void testVideoTest_positiveAndNegativeHandled() throws InterruptedException {
        VideoVkPage page = new VideoVkPage(driver);
        page.closeBtn();
        page.openTreading();
        page.openFirstVideo();
        Thread.sleep(3000);
        boolean isPlaying = page.isVideoPlaying();
        if (isPlaying) {
            System.out.println("Positive: видео воспроизводится корректно!");
            Assertions.assertTrue(true);
        } else {
            System.out.println("Negative: видео не воспроизводится");
            Assertions.fail("Таймер не изменился - видео НЕ воспроизводится");
        }
    }
}
