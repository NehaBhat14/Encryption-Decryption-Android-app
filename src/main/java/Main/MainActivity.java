package Main;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.encryptiondecryption.R;

import Encryption.EncryptionMain;

public class MainActivity extends AppCompatActivity {
    EncryptionMain encryptionMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = new MainFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
    }

    public void goToEncryption(View view) {
        encryptionMain = new EncryptionMain();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
        transaction.replace(R.id.container, encryptionMain);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void encryptionButtonClick(View view) {
        try {
            if (view.getId()==R.id.Switch)
                encryptionMain.switchAlgho(view);
            else if (view.getId()==R.id.Encrypt_Button)
                encryptionMain.encrypt(view);
            else if (view.getId()==R.id.Decrypt_Button)
                encryptionMain.decrypt(view);
            else if (view.getId()==R.id.copy_button)
                encryptionMain.copyToClipboard(view);
            else if (view.getId()==R.id.reset_button)
                encryptionMain.reset(view);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}

