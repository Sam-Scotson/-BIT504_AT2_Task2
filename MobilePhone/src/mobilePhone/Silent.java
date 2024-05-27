package mobilePhone;

class Silent implements MobilePhoneState {
    @Override
    public void incomingCall(MobilePhone phone) {
        System.out.println("....");
    }
}