
GROUP 12
LAWYER FINDER APP

Members
1.	JOSEPHAT OMONDI     BIT/2022/51578
2.	FAITH WAIRIMU            BIT/2020/91206
3.	EVANS NDOLO                BIT/2022/51402
4.	ELTON NJUGUNA           BIT/2022/51464
5.	VICTOR KIMUGE            BIT/2022/30937




















APP DESCRIPTION 
An app connecting clients with lawyers and streamlining scheduling holds strong potential by addressing the challenges both parties face.  For clients, it offers a convenient platform to search for lawyers based on specialization, location, and availability, while for lawyers, it simplifies appointment management, reduces no-shows, and potentially attracts new clients. Key features should include comprehensive lawyer profiles, advanced search filters, easy scheduling, secure communication, payment integration, robust calendar management for lawyers, and a review system.  Success hinges on overcoming competition, ensuring data privacy and security, effectively onboarding lawyers, and implementing a strong marketing strategy. Similar applications to our application are ClickUp, Esheria, WakiliCMS. ClickUp uses AI tool to enable efficient communication. Esheria creates and manage case files. WakiliCMS is a comprehensive software solution aimed at streamlining the day-to-day activities of law firms. Our application is unique in that it allows clients to find qualified lawyers near them.

Tools and Technologies 
1. Development Platforms & Technologies:
 Native Mobile Development (Android):  Using Kotlin/Java (Android) 
 Cross-Platform Development: Android
 Backend Development (Server-Side): Node.js
2. Database:
 Relational Databases (SQL):  MySQL 
3. APIs & Integrations:
 Payment Gateways (Stripe, PayPal, M-Pesa)
 Calendar APIs (Google Calendar):  Allow lawyers to sync their existing calendars with the app.
Mapping Services (Google Maps):  Integrate maps for location-based searches and directions.
Messaging APIs (SendBird):  Enable real-time chat and notifications.
4. Design & UX:
User-Centered Design:  Focus on creating a user-friendly and intuitive interface. Conduct user research and testing to ensure the app meets the needs of both clients and lawyers.
 UI/UX Design Tools (Figma) 
5. Testing & Quality Assurance:
 Unit Testing:  Test individual components of the app to ensure they function correctly.
 Integration Testing:  Test how different parts of the app work together.
 User Acceptance Testing (UAT):  Have real users test the app to identify any usability issues.
6. Security:
 Data Encryption:  Encrypt sensitive data both in transit and at rest.
 Authentication & Authorization:  Implement secure user authentication and authorization mechanisms.
 Regular Security Audits:  Conduct regular security assessments to identify and address vulnerabilities.  Compliance with relevant data privacy regulations (like GDPR) is crucial.

Project Work-Schedule.

	Week 1	Week 2	Week 3	Week 4	Week 5	Week 6	Week 7	Week 8
Project planning and research								
Wireframing & UI/UX Design								
Backend Development Setup								
Frontend Development (Part 1)								
Frontend Development (Part 2) & Payment Integration								
Testing & Debugging								
User Feedback								
Presentation Preparation								






PERFOMANCE OPTIMIZATION
1. Memory Optimization
 Steps Taken:
•	Avoided Memory Leaks: 
o	Properly managed context references, especially in activities and fragments.
o	Used ViewModel and LiveData to manage UI-related data in a lifecycle-conscious way.
•	Optimized RecyclerViews: 
o	Implemented ViewHolder pattern properly.
o	Used setHasFixedSize(true) to improve layout performance.
________________________________________
 2. CPU Optimization
Steps Taken:
•	Moved heavy operations off the main thread: 
o	Implemented background threading using Kotlin Coroutines 
•	Lazy Loading: 
o	Loaded data on demand to minimize processing large datasets at once.
•	Optimized Layout Hierarchies: 
o	Used ConstraintLayout to reduce nested views and speed up rendering.
o	Removed unnecessary overdraws.
•	Profiling: 
o	Used Android Studio Profiler to analyze and optimize CPU usage.
________________________________________
 3. Network Optimization
 Steps Taken:
•	Efficient API Calls: 
o	Optimized REST API calls using Retrofit 
o	Implemented caching strategies to minimize repeated requests.
•	Data Compression: 
o	Enabled GZIP compression for API responses where supported.
•	Pagination: 
o	Implemented pagination when loading large lawyer lists to avoid loading all data at once.
  
 


DEPLOYMENT STRATEGY
Steps followed in deploying the app on GitHub
1. Initialize Git in the Project Folder
Navigate to your project root directory using terminal or command prompt:
•	This initializes a new Git repository locally.
2. Create a New Repository on GitHub
•	Log in to GitHub
•	Click “New Repository”
•	Name it ( lawyer-finder-app)
•	Add description 
•	Choose Public 
•	Click Create Repository
 3. Add Remote Origin
git remote add origin https://github.com/your-username/lawyer-finder-app.git
4. Add Files to Staging
Stage all project files:
5. Commit the Changes
git commit -m "Initial commit - Lawyer Finder App"
6. Push the Project to GitHub
Push your project files to the GitHub repository





CHALLENGES AND SOLUTIONS
 1: Large File Sizes
 Pushing the large build files caused delays or exceeded GitHub’s file size limits.
Solution:
•	Created a .gitignore file to exclude unnecessary files and folders like. This reduced repository size and improved push speed.
  2: Version Control Conflicts
Merge conflicts occurred when collaborating or pulling changes from GitHub.
Solution:
•	Adopted good Git practices: 
o	Regularly pulling updates before pushing
o	Creating feature branches for new changes: 
o	Resolving conflicts locally before final push
________________________________________
3: Deployment Errors on GitHub Pages.
React App failed to load CSS or JavaScript when deployed via GitHub Pages due to incorrect homepage routing.
Solution:
•	Updated package.json with the correct homepage: 
•	Deployed using: npm run deploy
 4: Understanding GitHub Workflows.
Initial confusion about GitHub workflows, pushing, pulling, and merging branches.
Solution:
•	Studied basic Git commands and GitHub workflow.
•	Practiced using pull requests and merge approvals when collaborating.
•	Enabled branch protection rules to avoid direct pushes to the main branch.





FUTURE IMPROVEMENTS
1. Chat and Consultation Feature
•	Add a real-time chat system to allow clients to communicate with lawyers directly within the app.
•	Implement video call consultations for virtual legal advice.
2. AI Chabot for Legal FAQs
•	Develop a chatbot that answers common legal questions and guides users on how to use the app.
3. Multilingual Support
•	Provide the app in Swahili, French, and other languages to improve accessibility.
4. Hosting and Cloud Migration
•	Migrate to cloud services like AWS or Azure for better scalability, security, and availability.
•	Add Continuous Integration/Continuous Deployment (CI/CD) pipelines for automated updates.
CONCLUSION
Summary of the Development Experience
Several key stages were completed including:
•	Requirement gathering to understand user needs.
•	Wireframing and UI design to ensure user-friendly navigation.
•	Backend development using Node.js and PostgreSQL for database management.
•	Frontend development using React.js and Tailwind CSS for responsiveness.
•	API integration to enable dynamic lawyer listings and search functionalities.
•	Performance optimization to improve app speed, memory usage, and network requests.
•	Testing and deployment on GitHub for version control and collaboration.
 Key Takeaways
•	User experience (UX) is critical when building service-oriented platforms—simplicity and ease of use drive engagement.
•	The importance of proper database design and secure connections was evident, especially when handling sensitive user data.
•	Testing and debugging were crucial for catching performance bottlenecks and ensuring app stability.
•	Deployment using GitHub helped streamline version control and collaboration.

 Reflections
The project highlighted the challenges of balancing functionality and performance. Addressing issues like database connectivity, API design, and UI responsiveness required constant learning and problem-solving. However, overcoming these obstacles enhanced both technical skills and the understanding of full-stack application development.
REFERENCES
1.	React.js Documentation
https://react.dev/
Used for building the front-end components of the application.
2.	Node.js Official Documentation
https://nodejs.org/en/docs/
Referred to for backend development and server-side scripting.
3.	Tailwind CSS Documentation
https://tailwindcss.com/docs
For designing responsive and modern UI components.
4.	GitHub Documentation
https://docs.github.com/en
Used for understanding Git version control and deployment strategies.
5.	Android Developers Documentation
https://developer.android.com/docs
Used for performance optimization techniques and app development references.
6.	W3Schools - Web Development Tutorials
https://www.w3schools.com/
For general JavaScript, CSS, and HTML knowledge.




![image](https://github.com/user-attachments/assets/766dd815-6117-4c04-a7eb-7de5817b3de2)

![image](https://github.com/user-attachments/assets/d211857b-18e8-4824-9366-74cb18af5bb4)
![image](https://github.com/user-attachments/assets/8ad11c50-faa0-4df7-a91f-c6ce240ca7f1)





