package com.example.parcial2bd;

        import android.content.Context;
        import android.database.Cursor;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.CursorAdapter;
        import android.widget.TextView;

public class ListarCedulas extends CursorAdapter {
    public ListarCedulas(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.datos, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nombre  = (TextView) view.findViewById(R.id.txtnombres);
        TextView salario = (TextView) view.findViewById(R.id.txtsalario);
        TextView cedulas = (TextView) view.findViewById(R.id.txtcedula);
        TextView estrato = (TextView) view.findViewById(R.id.txtestrato);
        TextView ne = (TextView) view.findViewById(R.id.txtniveleducativo);
        // Extract properties from cursor
        String cedula = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
        String nombres = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
        String estratos = cursor.getString(cursor.getColumnIndexOrThrow("estrato"));
        String salarios = cursor.getString(cursor.getColumnIndexOrThrow("salario"));
        String nivel_educativo = cursor.getString(cursor.getColumnIndexOrThrow("nivel_educativo"));
        // Populate fields with extracted properties
        cedulas.setText("Cedula: " + cedula);
        nombre.setText("Nombre:" + nombres);
        estrato.setText("Estrato" + estratos);
        salario.setText("Salario: $"+salarios);
        ne.setText("Nivel educativo:" + nivel_educativo);

    }
}