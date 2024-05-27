package mobilePhone;

class VibrateOnly implements MobilePhoneState {
    @Override
    public void incomingCall(MobilePhone phone) {
        System.out.println("Bzzz");
    }
}