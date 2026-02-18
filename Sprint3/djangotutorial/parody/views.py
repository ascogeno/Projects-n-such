from django.shortcuts import render, redirect
from .forms import ParodyScamForm
import random

def home(request):
    if request.method == 'POST':
        form = ParodyScamForm(request.POST)
        if form.is_valid():
            request.session['scam_report'] = form.cleaned_data
            return redirect('report')
    else:
        form = ParodyScamForm()
    
    return render(request, 'parody/home.html', {'form': form})

def report(request):
    scam_report = request.session.get('scam_report')
    if not scam_report:
        return redirect('home')
    
    # Generate a random scam score for fun
    rng = random.Random()
    report_data = {
        "ip_adress": ".".join(str(rng.randint(1, 255)) for _ in range(4)),
        "connected_devices": rng.randint(1, 5),
        "threat_level": rng.choice(['Low', 'Medium', 'High']),
        "password": rng.choice(['password123', 'letmein', 'qwerty']),
        "location": rng.choice(['Unknown', 'Somewhere in the world', 'Definitely not your country']),
        "warning_count": rng.randint(1, 10)
    }
    
    return render(
        request, 
        'parody/report.html', 
        {'user': scam_report, 'report': report_data})