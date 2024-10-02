package co.com.myapp.cesde;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registro extends AppCompatActivity {

    FirebaseDatabase dataBase = FirebaseDatabase.getInstance();

    DatabaseReference reference = dataBase.getReference().child("usuarios");

    Button btnVolverDesdeRegistroAhome;
    EditText inputIdUsuario;
    EditText inputNombreUsuario;
    EditText inputApellidoUsuario;
    EditText inputCorreoUsuario;
    EditText inputTelefonoUsuario;
    EditText inputContrasena;
    Button btnGuardarUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnVolverDesdeRegistroAhome = findViewById(R.id.btn_volver_reg);
        inputNombreUsuario = findViewById(R.id.input_user_name);
        inputIdUsuario = findViewById(R.id.input_user_id);
        inputApellidoUsuario = findViewById(R.id.input_user_lastname);
        inputCorreoUsuario = findViewById(R.id.input_user_email);
        inputTelefonoUsuario = findViewById(R.id.input_user_phone);
        inputContrasena = findViewById(R.id.input_user_password);
        btnGuardarUsuario = findViewById(R.id.btn_registrar);

        btnGuardarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearUsuario();
            }
        });
    }

    public void crearUsuario(){
        String idUsuario = inputIdUsuario.getText().toString(); //este lo obtiene del input
        DatabaseReference nuevoUsuario = reference.child(idUsuario); //lo guarda en reference

        String nombre = inputNombreUsuario.getText().toString();
        nuevoUsuario.child("Nombre").setValue(nombre);

        String apellido = inputApellidoUsuario.getText().toString();
        nuevoUsuario.child("Apelldio").setValue(apellido);

        String correo = inputCorreoUsuario.getText().toString();
        nuevoUsuario.child("Correo").setValue(correo);

        String telefono = inputTelefonoUsuario.getText().toString();
        nuevoUsuario.child("Telefono").setValue(telefono);

        String contrasena = inputContrasena.getText().toString();
        nuevoUsuario.child("Contraseña").setValue(contrasena);

        Toast.makeText(getApplicationContext(),"Usuario Creado Exitosamente!!", Toast.LENGTH_LONG).show();
    }
}