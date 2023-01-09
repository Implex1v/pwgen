<script lang="ts">
    import type PasswordEvent from "../components/PasswordGenerator.svelte";
    import PasswordCard from "../components/PasswordCard.svelte";
    import PasswordGenerator from "../components/PasswordGenerator.svelte";
    import type { PasswordModel } from "$lib/types";
    import type PasswordDeleteEvent from "../components/PasswordCard.svelte";

    let passwords: Array<PasswordModel> = [];

    async function addPassword(event: CustomEvent<PasswordEvent>) {
        const model: PasswordModel = {
            password: event.detail.password,
            generatedAt: new Date(),
        }

        const tmp = [model];
        tmp.push(...passwords);
        passwords = tmp;
    }

    async function deletePassword(event: CustomEvent<PasswordDeleteEvent>) {
        passwords = passwords.filter((password) => { return password.password != event.detail.password.password });
    }
</script>

<p class="text-3xl py-4">Generate Password</p>

<div class="py-2">
    <PasswordGenerator on:password={addPassword} />
</div>

<p class="text-2xl py-4">History</p>

{#each passwords as password}
    <PasswordCard {password} on:passwordDelete={deletePassword} />
{/each}
