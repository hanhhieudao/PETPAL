package SwipePage;
import entity.PetProfiles.DogProfile;
import entity.PetProfiles.DogProfileBuilder;
import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.ArrayList;
import java.net.URL;
import javax.imageio.ImageIO;


public class NewSwipePage extends JFrame {
    private JLabel nameLabel, sizeLabel, photosLabel;
    private JButton likeButton, dislikeButton;
    private SwipePageController controller;

    public NewSwipePage(SwipePageController controller) {
        this.controller = controller;
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        // Profile panel
        nameLabel = new JLabel();
        sizeLabel = new JLabel();
        photosLabel = new JLabel();

        JPanel profilePanel = new JPanel(new GridLayout(3, 1));
        profilePanel.add(nameLabel);
        profilePanel.add(sizeLabel);
        profilePanel.add(photosLabel);

        likeButton = new JButton("Like");
        dislikeButton = new JButton("Dislike");

        likeButton.addActionListener(e -> controller.onLike());
        dislikeButton.addActionListener(e -> controller.onDislike());

        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        likeButton = new JButton("Like");
        dislikeButton = new JButton("Dislike");
        buttonPanel.add(likeButton);
        buttonPanel.add(dislikeButton);
        add(profilePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void updateProfile(SwipePageViewModel viewModel) {
        nameLabel.setText(viewModel.getDisplayName());
        sizeLabel.setText(viewModel.getDisplaySize());

        try {
            URI uri = new URI(viewModel.getDisplayPhotoUrl());
            System.out.println("dafdsdfasfd");
            System.out.println(viewModel.getDisplayPhotoUrl());
            System.out.println("hasdf");
            URL url = uri.toURL();
            ImageIcon photo = new ImageIcon(ImageIO.read(url));
            photosLabel.setIcon(photo);
        } catch (Exception e) {
            photosLabel.setIcon(null);
            photosLabel.setText("Photo not available");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Sample PetProfiles delete later.
        List<DogProfile> profiles = new ArrayList<>();
        DogProfileBuilder JasonBuilder = new DogProfileBuilder("Jason");
        DogProfileBuilder SallyBuilder = new DogProfileBuilder("Sally");
        DogProfileBuilder DavidBuilder = new DogProfileBuilder("David");
        DogProfileBuilder GregBuilder = new DogProfileBuilder("Greg");
        DogProfileBuilder MirandaBuilder = new DogProfileBuilder("Miranda");
        DogProfile JasonDogRosy = JasonBuilder.build();
        DogProfile SallyDogDawson = SallyBuilder.build();
        DogProfile DavidDogRandy = DavidBuilder.build();
        DogProfile GregDogAlex = GregBuilder.build();
        DogProfile MirandaDogNemo = MirandaBuilder.build();
        JasonDogRosy.setName("Rosy");
        SallyDogDawson.setName("Dawson");
        DavidDogRandy.setName("Randy");
        GregDogAlex.setName("Alex");
        MirandaDogNemo.setName("Nemo");
        JasonDogRosy.setSex('F');
        SallyDogDawson.setSex('M');
        DavidDogRandy.setSex('M');
        GregDogAlex.setSex('M');
        MirandaDogNemo.setSex('M');
        JasonDogRosy.setBreed("Shiba Inu");
        SallyDogDawson.setBreed("Literal Wolf");
        DavidDogRandy.setBreed("Husky");
        GregDogAlex.setBreed("Dachshund");
        MirandaDogNemo.setBreed("Dalmatian");
        JasonDogRosy.setPetPhotoLink("https://ibb.co/c1nx7Fq");
        SallyDogDawson.setPetPhotoLink("https://ibb.co/CwgQJ2v");
        DavidDogRandy.setPetPhotoLink("https://ibb.co/wdpgrZr");
        GregDogAlex.setPetPhotoLink("https://ibb.co/MSfhj8Q");
        MirandaDogNemo.setPetPhotoLink("https://ibb.co/fGYmPZ1");
        JasonDogRosy.setAge(2);
        SallyDogDawson.setAge(3);
        DavidDogRandy.setAge(4);
        GregDogAlex.setAge(5);
        MirandaDogNemo.setAge(6);


        ProfileSwipingInteractor interactor = new ProfileSwipingInteractor(profiles);
        PetProfilePresenter presenter = new PetProfilePresenter();
        NewSwipePage view = new NewSwipePage(null);

        SwipePageController controller = new SwipePageController(interactor, presenter, view);
        view.setController(controller);

        SwingUtilities.invokeLater(() -> view.setVisible(true));
        controller.loadNextProfile();
    }

    public void setController(SwipePageController controller) {
        this.controller = controller;
    }
}