from django import forms
import re

class ParodyScamForm(forms.Form):
    nickname = forms.CharField(
        label='Hacker Nickname', 
        max_length=20,
        required=True,
        string=True,
        )
    maiden_name = forms.CharField(
        label='Mother\'s Maiden Name', 
        max_length=30,
        required=True,
        string=True,
        )
    favorite_number = forms.IntegerField(
        label='Favorite Number (1-999)', 
        required=True,
        min_value=1,
        max_value=999,
        )
    
    def clean_maiden_name(self):
        maiden_name = self.cleaned_data['maiden_name']
        if not re.fullmatch(r'^[A-Za-z\s]+$', maiden_name):
            raise forms.ValidationError("Mother's Maiden Name must contain only letters and spaces.")
        return maiden_name