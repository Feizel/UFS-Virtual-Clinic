package wolvesofwallstreet.UFS.ufsclinic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuickTipsAdapter extends RecyclerView.Adapter<QuickTipsAdapter.QuickTipsViewHolder> {

    private List<QuickTipItem> quickTipItems;
    private Context context;

    public QuickTipsAdapter(Context context, List<QuickTipItem> quickTipItems) {
        this.context = context;
        this.quickTipItems = quickTipItems;
    }

    @NonNull
    @Override
    public QuickTipsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_quick_tip, parent, false);
        return new QuickTipsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuickTipsViewHolder holder, int position) {
        QuickTipItem item = quickTipItems.get(position);

        holder.imageView.setImageResource(item.getImageResource());
        holder.titleTextView.setText(item.getTitle());
        holder.contentTextView.setText(item.getContent());
    }

    @Override
    public int getItemCount() {
        return quickTipItems.size();
    }

    static class QuickTipsViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTextView;
        TextView contentTextView;

        QuickTipsViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.quickTipImage);
            titleTextView = itemView.findViewById(R.id.quickTipTitle);
            contentTextView = itemView.findViewById(R.id.quickTipContent);
        }
    }
}
