public class Reimbursment {

    public static int calcReimbursment(boolean deductible, boolean doctorsVisit){

        if(!deductible) return 0;
        if(doctorsVisit) return 50;
        return 80;
    }

}
