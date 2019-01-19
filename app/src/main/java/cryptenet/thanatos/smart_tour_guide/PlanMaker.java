package cryptenet.thanatos.smart_tour_guide;

import android.os.Bundle;

import java.util.ArrayList;

import cryptenet.thanatos.smart_tour_guide.models.Result;

public class PlanMaker {
    Bundle bundle;

    public PlanMaker(Bundle bundle) {
        setBundle(bundle);
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public ArrayList<Result> gerenatePlan(){
        ArrayList<Result> result = new ArrayList<>();

        if (bundle.get(String.valueOf(R.string.bundle_interest)).toString().equals("Waterfalls")) {
            Result result11 = new Result("Dhaka > Sylhet (Shreemangal) > Hum Hum WaterFalls", 1500, 1);
            Result result12 = new Result("Dhaka > Sylhet (Shreemangal) > Hum Hum WaterFalls", 2500, 2);

            Result result21 = new Result("Dhaka > Chittagong > Cox's Bazar > Himchori Waterfalls", 3000, 1);
            Result result22 = new Result("Dhaka > Chittagong > Cox's Bazar > Himchori Waterfalls", 4000, 2);

            Result result31 = new Result("Dhaka > Chittagong > Thanchi > Balkai Waterfalls > Faipi Waterfalls > Jadipai Waterfalls > RumanaPara Waterfalls", 5000, 3);
            Result result32 = new Result("Dhaka > Chittagong > Thanchi > Balkai Waterfalls > Faipi Waterfalls > Jadipai Waterfalls > RumanaPara Waterfalls", 6500, 5);

            result.add(result11);
            result.add(result12);
            result.add(result21);
            result.add(result22);
            result.add(result31);
            result.add(result32);
        } else if (bundle.get(String.valueOf(R.string.bundle_interest)).toString().equals("Hills")) {
            Result result11 = new Result("Dhaka > Chittagong > Chimbuk Hills > KeokraDong", 4000, 3);
            Result result12 = new Result("Dhaka > Chittagong > Chimbuk Hills > KeokraDong", 5500, 4);

            result.add(result11);
            result.add(result12);
        } else if (bundle.get(String.valueOf(R.string.bundle_interest)).toString().equals("Sea Side")) {
            Result result11 = new Result("Dhaka > Barisal > Kuakata", 4000, 3);
            Result result12 = new Result("Dhaka > Barisal > Kuakata", 5500, 4);

            Result result21 = new Result("Dhaka > Patuakhali > Kuakata", 3800, 3);
            Result result22 = new Result("Dhaka > Patuakhali > Kuakata", 5000, 4);

            Result result31 = new Result("Dhaka > Chittagong > Cox's Bazar", 4000, 2);
            Result result32 = new Result("Dhaka > Chittagong > Cox's Bazar", 5500, 4);
            Result result33 = new Result("Dhaka > Chittagong > Cox's Bazar", 8500, 4);

            result.add(result11);
            result.add(result12);
            result.add(result21);
            result.add(result22);
            result.add(result31);
            result.add(result32);
            result.add(result33);
        }

        return result;
    }
}
