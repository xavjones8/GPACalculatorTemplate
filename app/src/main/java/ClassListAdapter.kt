import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.example.gpacalculator_master.R

class ClassListAdapter(private val context: Activity, private val classes: MutableList<ClassRowDetails>): ArrayAdapter<ClassRowDetails>(context, R.layout.semester_list_row, classes) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.semester_list_row, null, true)

        return rowView
    }

}