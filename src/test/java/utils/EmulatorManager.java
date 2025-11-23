package utils;

public class EmulatorManager {
    private Process emulatorProcess;
    public void startEmulator(String avdName) throws Exception {
        String emulatorPath = System.getenv("ANDROID_HOME") + "/emulator/emulator";
        ProcessBuilder pb = new ProcessBuilder(emulatorPath, "-avd", avdName);
        pb.inheritIO();
        emulatorProcess = pb.start();
        Thread.sleep(20000);
    }

    public void stopEmulator() throws Exception {
        if (emulatorProcess != null) {
            emulatorProcess.destroy();
            emulatorProcess.waitFor();
        }
    }
}
