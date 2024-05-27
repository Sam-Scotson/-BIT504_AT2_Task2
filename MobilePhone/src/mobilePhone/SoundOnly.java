package mobilePhone;

class SoundOnly implements MobilePhoneState {
    @Override
    public void incomingCall(MobilePhone phone) {
        System.out.println("Beep!");
    }
}