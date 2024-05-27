package mobilePhone;

class SoundAndVibrate implements MobilePhoneState {
    @Override
    public void incomingCall(MobilePhone phone) {
        System.out.println("BzzzBeepBzzz");
    }
}
