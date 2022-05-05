import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.*;
import java.util.concurrent.TimeUnit;

public class theRealTroll {
    static Runtime rt = Runtime.getRuntime();
    static String url = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
    static String[] browsers = { "google-chrome", "firefox", "mozilla", "epiphany", "konqueror","netscape", "opera", "links", "lynx" };

    public static void main(String[] args){

        String osname = System.getProperty("os.name");
        Mouse mouse = new Mouse();

        if(osname.toLowerCase().startsWith("linux")){
            StringBuffer cmd = new StringBuffer();
            for (int i = 0; i < browsers.length; i++)
                if(i == 0)
                    cmd.append(String.format(    "%s \"%s\"", browsers[i], url));
                else
                    cmd.append(String.format(" || %s \"%s\"", browsers[i], url));

            try {

                rt.exec(new String[] { "sh", "-c", cmd.toString() });
                mouse.start();
                try {
                    TimeUnit.SECONDS.sleep(7);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                pressK();
                try {
                    TimeUnit.SECONDS.sleep(20);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.exit(0);
            }
            catch (Exception e) {e.printStackTrace();}
        }

        if(osname.toLowerCase().startsWith("win")){

            try {

                try {
                    Desktop.getDesktop().browse(new URI(url));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                mouse.start();
                try {
                    TimeUnit.SECONDS.sleep(7);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                pressK();
                try {
                    TimeUnit.SECONDS.sleep(20);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.exit(0);
            } catch (Exception e) {e.printStackTrace();}
        }

        if(osname.toLowerCase().startsWith("mac")){
            try {rt.exec("open " + url);
                mouse.start();
                try {
                    TimeUnit.SECONDS.sleep(7);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                pressK();
                try {
                    TimeUnit.SECONDS.sleep(20);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.exit(0);
            }
            catch (IOException e) {e.printStackTrace();}
        }

    }

    public static void pressK() {
        try {
            Robot kb = new Robot();
            kb.keyPress(KeyEvent.VK_K);
            TimeUnit.MILLISECONDS.sleep(400);
            kb.keyRelease(KeyEvent.VK_K);
        } catch (Exception e) {
        }
    }

}


class Mouse extends Thread {
    @Override
    public void run() {
        try {
            Robot robot = new Robot();
            while (true) {
                robot.mouseMove(0, 0);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
