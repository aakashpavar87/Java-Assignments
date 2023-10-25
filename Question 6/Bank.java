import Mypackage.Account;
class Savings extends Account{
    public int interestRate;
    public Savings(String acc,String bal,int intrate) {
        super(acc,bal);
        interestRate = intrate;
    }
}
class Current extends Account{
    public float overDraftLimit;
    public current(String acc,String bal,float lim) {
        super(acc,bal);
        overDraftLimit = lim;
    }

}