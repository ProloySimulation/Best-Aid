package com.best_aid.proloy.lifesaver.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.best_aid.proloy.lifesaver.Model.Question;
import com.best_aid.proloy.lifesaver.R;

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
        holder.tvAns.setText(question.getComment());
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvQuestion;
        TextView tvAns  ;
        LinearLayout expendable ;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);

            tvQuestion = itemView.findViewById(R.id.tvQuestions);
            cardView = itemView.findViewById(R.id.card);
            tvAns = itemView.findViewById(R.id.tvAnswer);


        }
    }


}

