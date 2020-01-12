package com.example.proloy.lifesaver.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.proloy.lifesaver.Model.Question;
import com.example.proloy.lifesaver.R;

import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter <QuestionAdapter.ViewHolder> {

    private Context context;
    private List<Question> questionList;


    public QuestionAdapter(Context context, List<Question> questionList) {
        this.context = context;
        this.questionList = questionList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_question, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(QuestionAdapter.ViewHolder holder, int position) {
        Question question = questionList.get(position);

        holder.tvQuestion.setText(question.getDescription());
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvQuestion;
        TextView tvClick ;
        LinearLayout expendable ;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);

            tvQuestion = itemView.findViewById(R.id.tvQuestions);
            tvClick = itemView.findViewById(R.id.click);
            expendable = itemView.findViewById(R.id.llAnswer);
            cardView = itemView.findViewById(R.id.card);

            tvClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (expendable.getVisibility()==View.GONE){
                        TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                        expendable.setVisibility(View.VISIBLE);
                    }
                    else {
                        TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                        expendable.setVisibility(View.GONE);
                    }
                }
            });

        }
    }


}
