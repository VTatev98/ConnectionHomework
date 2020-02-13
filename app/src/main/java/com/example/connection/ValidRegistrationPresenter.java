package com.example.connection;



public class ValidRegistrationPresenter {
    private OnValidDataListener onValidDataListener;
    private CheckConnection checkConnection;

    public ValidRegistrationPresenter(OnValidDataListener onValidDataListener) {
        this.onValidDataListener = onValidDataListener;
        checkConnection = new CheckConnection();
    }

    public void isValidData(String username, String password,String repPass) {
        RegistrationValidation loginValidation = new RegistrationValidation();
        //if (!checkConnection.isConnected())
          //  return;
        if (loginValidation.isValidUsername(username) &&
                loginValidation.isValidPassword(password,username) && loginValidation.isRepeatePasswordValid(password,repPass))
        {
            SingletoneSession.Instance().setUser(username, password);
           // users.put(username, password);
            onValidDataListener.isValidData();
        }
        else
            onValidDataListener.onDataError();


}
    public void isValidLogin(String username,String password){
        if((SingletoneSession.Instance().getUser().containsKey(username))&&
                (SingletoneSession.Instance().getUser().get(username).equals(password)))
            onValidDataListener.isValidData();
 }
}

