# Java Interview Training Platform

## Architecture Overview
- **Frontend**: Next.js App Router + TypeScript + Tailwind + Monaco for coding editor.
- **Backend**: Spring Boot REST API with layered architecture (controllers/services/repositories), JWT security, DTO validation, global exception handling.
- **Database**: PostgreSQL with JPA entities for users, progress, coding attempts, mock results, and tutor history.
- **AI Tutor**: Provider-configurable service (OpenAI or Ollama URL), with mode-based responses and persisted conversation history.

## Folder Structure
- `frontend/` Next.js multi-page app
- `backend/` Spring Boot service
- `.github/workflows/` CI pipeline

## Database Schema (Core)
- `users(id,email,password_hash,full_name,created_at)`
- `level_progress(id,user_id,level_number,theory_completed,coding_completed,completion_percent)`
- `coding_attempt(id,user_id,problem_id,code,passed,score,execution_ms,created_at)`
- `mock_interview_result(id,user_id,company,score,feedback,created_at)`
- `tutor_message(id,user_id,mode,role,content,created_at)`

## Deployment Plan
- Frontend deploy on Vercel using `frontend/vercel.json`.
- Backend deploy on Render/Railway via Dockerfile in `backend/`.
- Configure environment variables from `.env.example` files.
- Use GitHub Actions workflow for build/lint/test verification.

## Run Locally
### Backend
```bash
cd backend
mvn spring-boot:run
```

### Frontend
```bash
cd frontend
npm install
npm run dev
```
