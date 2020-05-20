package MVC;

import Controller.ProfileController;
import Model.ProfileModel;
import View.ProfileView;

public class ProfileMVC {
    String data[][];

    public ProfileMVC(String[][] data) {
        this.data = data;
        ProfileModel model = new ProfileModel();
        ProfileView view = new ProfileView();
        ProfileController controller = new ProfileController(model,view,data);
    }
}
