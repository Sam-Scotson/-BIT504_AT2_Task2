package mobilePhone;

public class Main {
    public static void main(String[] args) {
        // Create the initial state
        MobilePhone phone = new MobilePhone(new Silent());
        phone.incomingCall();

        // Switch to VibrateOnly mode
        phone.setState(new VibrateOnly());
        phone.incomingCall();

        // Switch to SoundOnly mode
        phone.setState(new SoundOnly());
        phone.incomingCall();

        // Switch to SoundAndVibrate mode
        phone.setState(new SoundAndVibrate());
        phone.incomingCall();

        // Switch back to Silent mode
        phone.setState(new Silent());
        phone.incomingCall();
    }
}