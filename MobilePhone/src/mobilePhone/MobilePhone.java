package mobilePhone;

class MobilePhone {
    private MobilePhoneState currentState; // The current state

    public MobilePhone(MobilePhoneState initialState) {
        currentState = initialState; // Constructor setting initial state
    }

    public void setState(MobilePhoneState state) {
        currentState = state;
    }

    public void incomingCall() { // Perform the unique action of the state
        currentState.incomingCall(this);
    }
}